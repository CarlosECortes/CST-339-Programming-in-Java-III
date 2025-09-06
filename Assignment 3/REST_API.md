**CST-339 Programming in Java III**  
**Carlos Cortes**  
**2025**  

---

# REST API Design Document - Get Orders as JSON

---

## `/service/getjson`

**Fetch all orders in JSON format**  

**URL**  
`/service/getjson`  

**Method:**  
`GET`  

**URL Params**  
- **Required:** None  
- **Optional:** None  

**Data Params**  
- None (this is a `GET` request)  

**Success Response:**  
- **Code:** 200 OK  
- **Content:**  
```json
[
  { "id": 1, "orderNo": "A1001", "productName": "Sword of Destiny", "price": 199.99, "quantity": 1 },
  { "id": 2, "orderNo": "A1002", "productName": "Mjolnir", "price": 49.99, "quantity": 2 }
]
```
**Notes**
Returns list of orders as JSON array. No authentications required

---

# REST API Design – Get Orders as XML

**Fetch Orders (XML Format)**  

**URL**  
`/service/getxml`  

**Method**  
`GET`  

**URL Params**  
- **Required:**  None
- **Optional:**  None

**Data Params**  
- None (this is a `GET` request).  

**Success Response:**  
- **Code:** 200 OK  
- **Content Example:**  
```xml
<orders>
  <orderModel>
    <id>1</id>
    <orderNo>A1001</orderNo>
    <productName>Sword of Destiny</productName>
    <price>199.99</price>
    <quantity>1</quantity>
  </orderModel>
  <orderModel>
    <id>2</id>
    <orderNo>A1002</orderNo>
    <productName>Mjolnir</productName>
    <price>49.99</price>
    <quantity>2</quantity>
  </orderModel>
</orders>
```
**Notes***
Returns list of orders as XML wrapped in <orders>. Requires JAXB runtime dependency (Jakarta XML Binding) to function properly.