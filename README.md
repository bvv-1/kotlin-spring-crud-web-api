### HelloWorld
https://start.spring.io/ で、Kotlin, Spring Boot 2.7.14, Java17を指定して作成

と思ったら、早速いろいろつまりました。
- packageがcould not be resolvedのエラー
  - npm installの感覚で、build.gradle.ktsに`implementation("org.springframework.boot:spring-boot-starter-web")`を追加
  - なんなら、start.spring.ioで追加できた
- Javaのversionが低くてコンパイルが通らない
  - asdf install java corretto-17.0.8.7.1
  - asdf global java corretto-17.0.8.7.1
- 83% EXECUTING という表示でも起動できている（酷い）

### API

- 