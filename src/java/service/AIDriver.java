///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package service;
//
///**
// *
// * @author PC
// */
//
//import okhttp3.*; import org.json.JSONObject;
//
//public class AIDriver {
//    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
//    private String apiKey = System.getenv("OPENAI_API_KEY");
//
//    public String generateAIResponse(String userMessage){
//        if(apiKey==null || apiKey.isEmpty()) return simpleReply(userMessage);
//        OkHttpClient client = new OkHttpClient();
//        JSONObject req = new JSONObject()
//            .put("model","gpt-4o-mini")
//            .put("messages", new org.json.JSONArray()
//                .put(new JSONObject().put("role","system").put("content","Bạn là tài xế AI thân thiện, trả lời ngắn gọn, lịch sự."))
//                .put(new JSONObject().put("role","user").put("content", userMessage))
//            );
//        RequestBody body = RequestBody.create(req.toString(), MediaType.parse("application/json"));
//        Request request = new Request.Builder().url(API_URL)
//            .header("Authorization","Bearer "+apiKey).post(body).build();
//        try (Response resp = client.newCall(request).execute()){
//            if(!resp.isSuccessful()) return "Tài xế AI đang bận, thử lại sau.";
//            String s = resp.body().string();
//            JSONObject o = new JSONObject(s);
//            return o.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
//        } catch(Exception e){ e.printStackTrace(); return "Lỗi khi liên hệ AI."; }
//    }
//
//    private String simpleReply(String msg){
//        msg = msg.toLowerCase();
//        if(msg.contains("đi đâu")) return "Bạn muốn đi đâu ạ? Tôi có thể gợi ý điểm đến.";
//        if(msg.contains("ở đâu")) return "Xe đang gần vị trí của bạn, dự kiến đến trong 5 phút.";
//        return "Chào bạn! Tôi là tài xế AI, tôi có thể giúp gì?";
//    }
//}