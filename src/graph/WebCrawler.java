package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebCrawler {

    HashMap<String, Boolean> allVisitedURLs = new HashMap<>();
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void crawl(String url){

        Queue<String > linksOnURL = new LinkedList<>();
        linksOnURL.add(url);

        while (!linksOnURL.isEmpty()){
            String url1 =  linksOnURL.remove();
            System.out.println(url1);
            allVisitedURLs.put(url1, true);

            processParallel(url, linksOnURL);
        }
    }

    private void processParallel(String url, Queue<String> linksOnURL) {
        String[] list = visit(url);
        for (String newURL : list){
            crawlNewPage(newURL);
//
//            if(!allVisitedURLs.conlitainsKey(newURL)){
//                linksOnURL.add(newURL);
//            }
        }
    }

    private void crawlNewPage(String newURL) {
        //Thread firstURL = new Thread();
        executorService.submit(()-> "sdf");
    }

    // Return all links avaliable on page with URL
    private String[] visit(String url) {
        return new String[]{};
    }
}
