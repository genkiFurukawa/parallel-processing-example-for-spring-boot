# SpringBootで並列処理の実行調査サンプル
## 概要
- `curl http://localhost:8080`を実行すると、サーバーサイドでは6つの文字列出力の処理を並列で実行する
    - ただし、最大並列数を5としているので5個実行後に6個目の処理が実行される

## ざっくりとした理解
- @Asyncのアノテーションをつけて、`CompletableFuture`でラップすると並列実行できる
- application.ymlに並列実行可能数を設定する

## ログのサンプル
- 並列で処理を実行できているっぽい

```
2021-09-28 00:21:51.384  INFO 2798 --- [        prefix3] p.p.example.service.SampleService        : >> Async start
2021-09-28 00:21:51.384  INFO 2798 --- [        prefix4] p.p.example.service.SampleService        : >> Async start
2021-09-28 00:21:51.384  INFO 2798 --- [        prefix5] p.p.example.service.SampleService        : >> Async start
2021-09-28 00:21:51.384  INFO 2798 --- [        prefix1] p.p.example.service.SampleService        : >> Async start
2021-09-28 00:21:51.384  INFO 2798 --- [        prefix2] p.p.example.service.SampleService        : >> Async start
2021-09-28 00:21:52.386  INFO 2798 --- [        prefix3] p.p.example.service.SampleService        : << Async start
2021-09-28 00:21:52.387  INFO 2798 --- [        prefix3] p.p.example.service.SampleService        : >> Async start
2021-09-28 00:21:52.389  INFO 2798 --- [        prefix2] p.p.example.service.SampleService        : << Async start
2021-09-28 00:21:52.389  INFO 2798 --- [        prefix1] p.p.example.service.SampleService        : << Async start
2021-09-28 00:21:52.389  INFO 2798 --- [        prefix5] p.p.example.service.SampleService        : << Async start
2021-09-28 00:21:52.389  INFO 2798 --- [        prefix4] p.p.example.service.SampleService        : << Async start
2021-09-28 00:21:53.389  INFO 2798 --- [        prefix3] p.p.example.service.SampleService        : << Async start
```

## 参考
- [Spring Bootで並列処理を行う](https://pepecam.com/it/spring-boot-parallel/)
- [SpringBootの@AsyncとCompletableFutureを組み合わせて並列ロジックを作る](https://qiita.com/alpha_pz/items/663f6142ab99724d5aed)
- [アプリケーションプロパティ設定一覧](https://spring.pleiades.io/spring-boot/docs/current/reference/html/application-properties.html)
