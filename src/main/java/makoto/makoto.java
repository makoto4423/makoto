package makoto;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.*;

public class makoto {

    public static void main(String[] args){
        List<String>  a = new ArrayList<>();
        a.add("a");
        List<String> b = new ArrayList<>();
        b.add("a");
        Set<List<String>> stack = new HashSet<>();
        stack.add(a);stack.add(b);
        System.out.println(stack.size());

    }

}
