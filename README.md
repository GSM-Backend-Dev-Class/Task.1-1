# 과제 1-1(2025/02/18~2025/02/20)

[https://github.com/GSM-Backend-Dev-Class/Task.1-1](https://github.com/GSM-Backend-Dev-Class/Task.1-1)

## 💡요약

- 간단한 CRUD RESTful 서비스를 구현하는 것이 목표입니다
- 어떠한 기술을 사용하셔도 괜찮습니다,GraphQL이든 gRPC 든 자유롭게 자신있는 기술스택을 선정하여 진행하여 주세요
- 링크되어 있는 Repository를 Fork 또는 Clone 받아 완성되면 PR을 올려주세요
- 본격적으로 시작하기전 역량 점검 및 앞으로의 진행 방향성을 알리기 위하여 진행되는 과제로 가능한 빨리 완료되면 좋겠습니다!

## ✅ 요구사항

- 아래 API 명세서에 따라 구현하여 주세요
- SpringBoot를 이용하여 주세요
- 객체를 반환할 땐 반드시 <b>``ResponseEntity<>``</b>를 이용하여 주세요
- 전체 리소스를 요청하는 GET HTTP 요청에서는 리소스가 없더라도 404 Not Found 대신 빈 리스트를 반환하도록 구현하여 주세요
- master 브랜치가 아니라 <b>``task/{자신의 이름}``</b> 형태로 브랜치를 생성하여 main 브랜치를 향하여 PR을 걸어 주세요
- 기본적으로 생성되어 있는 클래스의 변경은 지양하여 주시고 Entity는 미리 생성된 <b>``BaseIdxEntity``</b>를 확장하여 사용하여 주세요

| Path                   | HTTP Method |
|------------------------|------------|
| /articles             | GET        |
| /articles/{articleId} | GET        |
| /articles             | POST       |
| /articles/{articleId} | PATCH      |
| /articles/{articleId} | DELETE     |
