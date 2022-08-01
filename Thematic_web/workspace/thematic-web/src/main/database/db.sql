use thematicweb;

insert into role(code,name) values('ADMIN','QuaÌ‰n triÌ£');
insert into role(code,name) values('USER','NgÆ°á»�i dÃ¹ng');

insert into cart(total) values (0);


insert into user(username,password,fullname, email, sex, status)
values('admin','123456','Admin','admin@gmail.com', 'male',1);
INSERT INTO user(username, password,fullname, email, sex, status, cart_id)
values('user','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','Nguyen Cong Du', 'dunguyen@gmail.com', 'male', 1, 1);


INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);

insert into category(code, name) values ('nhan-dinh', 'Nháº­n Ä‘á»‹nh');
insert into category(code, name) values ('du-doan', 'Dá»± Ä‘oÃ¡n');
insert into category(code, name) values ('chuyen-nhuong', 'Chuyá»ƒn nhÆ°á»£ng');
insert into category(code, name) values ('doi-bong', 'Ä�á»™i bÃ³ng');
insert into category(code, name) values ('cau-thu', 'Cáº§u thá»§');
insert into category(code, name) values ('khac', 'KhÃ¡c');
insert into category(code, name) values ('lich-phat-song', 'Lịch phát sóng');
insert into category(code, name) values ('huan-luyen-vien', 'Huấn luyện viên');
insert into category(code, name) values ('giai-dau', 'Giải đấu');

insert into new(title, shortdescription, content, category_id) values ('news 1', 'news 1', 'news 1', 1);
insert into new(title, shortdescription, content, category_id) values ('news 2', 'news 2', 'news 2', 1);
insert into new(title, shortdescription, content, category_id) values ('news 3', 'news 3', 'news 3', 2);
insert into new(title, shortdescription, content, category_id) values ('news 4', 'news 4', 'news 4', 3);

insert into cart_new(cartid, newid) values (1,1);
insert into cart_new(cartid, newid) values (1,2);

insert into comment(content, user_id, news_id, createdBy) values('this is a content', 1, 1, 'admin');
insert into comment(content, user_id, news_id, createdBy) values('That greate', 2, 1, 'user');



