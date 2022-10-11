#Поля
В ходе моей работы были опущены поля:
1. ####Метод add
    privacy_view, privacy_comment
2. ####Метод createComment
    reply_to, guid
3. ####Метод deleteComment
    owner_id
4. ####Метод edit
    privacy_view, privacy_comment
5. ####Метод editComment
    owner_id
6. ####Метод get
    user_id, offset, count, sort, notes_ids 

    По сути, сделал запрос на вывод всего массива
7. ####Метод getById
    owner_id, need_wiki
8. ####Метод getComments
    owner_id, sort, offset, count
9. ####Метод getFriendsNotes
    Данный метод отсутствует в моей работе. 
10. ####Метод restoreComment
    owner_id