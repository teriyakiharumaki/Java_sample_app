package com.example.demo.controller;
  
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.ModelAttribute;
  import org.springframework.web.bind.annotation.PostMapping;
  
  import com.example.demo.form.HelloForm;
  
  // コントローラークラス
  @Controller
  public class HelloController {
  
      // "/"へのGETリクエストを処理するメソッド
      @GetMapping("/")
      public String helloForm(Model model) {
          // 初期値として空のHelloFormオブジェクトをビューに渡す
          model.addAttribute("form", new HelloForm());
          // "hello.html"テンプレートをレンダリング
          return "hello";
      }
  
      // "/send"へのPOSTリクエストを処理するメソッド
      @PostMapping("/send")
      public String submitForm(@ModelAttribute HelloForm form, Model model) {
          // 受け取ったフォームデータをビューに返すためにModelに設定
          model.addAttribute("form", form); // フォームオブジェクトを再度ビューに渡す
          // 入力された名前を利用してメッセージを生成し、Modelに設定
          model.addAttribute("message", "Hello, " + form.getName() + "!");
          // "hello.html"テンプレートを再度レンダリング
          return "hello";
      }
  }