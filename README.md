
# Commerce Demo

Spring Boot project created according to this assignment.

![Uygulama Ekran Görüntüsü](https://lh3.googleusercontent.com/WrOGTyEaOSy2OGlTY78W3LRjCsKtOgZvSaDN66nPPiWUjayXcDkpeXmffEukFyWQTrVdqZTradZIiHZ-Hc_3TqJcgpZmmNwMNcSXUIg_G7mNIazk3cePMY4g0jcAnxCDAi7wRRLQEw=w2400)



## API Usage

### Product Comment Service

```http
/api/comment_product
```

| Link  | Parametre | Tip     | Açıklama                |
| :-------- | :-------- | :------- | :------------------------- |
| /product/`productId` | `productId` | `string` | Get product comments. |
| /product/`productId`/`startDate`/`endDate` | `productId - startDate - endDate` | `string - date - date` | Get product comments within a specified time. |
| /user/`userId` | `userId` | `string` | Get user comments. |
| /user/`userId`/`startDate`/`endDate` | `userId - startDate - endDate` | `string - date - date` | Get user comments within a specified time. |

### Product Service

```http
/api/product
```

| Link  | Açıklama                |
| :-------- | :------------------------- |
| /expired | Get out-of-date products. |
| /notproduct  | Brings products that have not expired. |
