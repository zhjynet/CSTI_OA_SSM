package com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * @author zhangjingyu
 */
public class LuceneUtils {
    public static void main(String[] args) throws Exception {
        // 1. 准备中文分词器
        IKAnalyzer analyzer = new IKAnalyzer();

        // 2. 索引
        List<String> productNames = new ArrayList<>();
        productNames.add("20166671WEB张靖宇");
        productNames.add("20166672WEB叶鹏飞");
        productNames.add("20166671WEB张靖");
        productNames.add("20166671WEB张宇");
        productNames.add("20166671WEB靖宇");
        Directory index = createIndex(analyzer, productNames);

        // 3. 查询器
        String keyword = "WEB组的张靖宇 ";
        Query query = new QueryParser("name", analyzer).parse(keyword);

        // 4. 搜索
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        int numberPerPage = 1000;
        System.out.printf("当前一共有%d条数据%n",productNames.size());
        System.out.printf("查询关键字是：\"%s\"%n",keyword);
        ScoreDoc[] hits = searcher.search(query, numberPerPage).scoreDocs;

        // 5. 显示查询结果
        showSearchResults(searcher, hits, query, analyzer);
        // 6. 关闭查询
        reader.close();
    }

    public static void showSearchResults(IndexSearcher searcher, ScoreDoc[] hits, Query query, IKAnalyzer analyzer)
            throws Exception {
        System.out.println("找到 " + hits.length + " 个命中.");
        System.out.println("序号\t匹配度得分\t结果");
        for (int i = 0; i < hits.length; ++i) {
            ScoreDoc scoreDoc= hits[i];
            int docId = scoreDoc.doc;
            Document d = searcher.doc(docId);
            List<IndexableField> fields = d.getFields();
            System.out.print((i + 1));
            System.out.print("\t" + scoreDoc.score);
            for (IndexableField f : fields) {
                System.out.print("\t" + d.get(f.name()));
            }
            System.out.println();
        }
    }

    public static Directory createIndex(IKAnalyzer analyzer, List<String> products) throws IOException {
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(index, config);

        for (String name : products) {
            addDoc(writer, name);
        }
        writer.close();
        return index;
    }

    private static void addDoc(IndexWriter w, String name) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("name", name, Field.Store.YES));
        w.addDocument(doc);
    }
}

