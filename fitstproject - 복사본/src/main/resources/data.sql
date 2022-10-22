insert into article (id,title,content,text) values( 1,'가가가','1111','ㅁㅁㅁㅁ');
insert into article (id,title,content,text) values( 2,'나나나','2222','ㄴㄴㄴㄴ');
insert into article (id,title,content,text) values( 3,'다다다','3333','ㅇㅇㅇㅇ');
--article 더미 데이터

insert into article (id,title,content,text) values( 4,'당신의 인생영화는?','댓글 ㄲ1','df');
insert into article (id,title,content,text) values( 5,'당신의 소울 푸드는?','댓글 ㄲ2','d');
insert into article (id,title,content,text) values( 6,'당신의 취미는?','댓글 ㄲ3','df');

--comment 더미 데이터
--4번
insert into comment (id,article_id,nickname,body) values( 1,4,'Park','굳 윌 헌팅');
insert into comment (id,article_id,nickname,body) values( 2,4,'Kim','아이앰샘');
insert into comment (id,article_id,nickname,body) values( 3,4,'Choi','쇼생크탈출');

--5번
insert into comment (id,article_id,nickname,body) values( 4,5,'Park','치킨');
insert into comment (id,article_id,nickname,body) values( 5,5,'Kim','샤브샤브');
insert into comment (id,article_id,nickname,body) values( 6,5,'Choi','초밥');

--6번

insert into comment (id,article_id,nickname,body) values( 7,6,'Park','조깅');
insert into comment (id,article_id,nickname,body) values( 8,6,'Kim','유튜브');
insert into comment (id,article_id,nickname,body) values( 9,6,'Choi','독서');

