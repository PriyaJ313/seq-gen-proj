# seq-gen-proj
Project to get the random tracking number for different Client purpose.

**Deployed URL:**

This project is deployed in Railway.app and avaiable in the below link.

https://seq-gen-proj-production.up.railway.app/api/next-tracking-number

**API Details:**

GET -> https://seq-gen-proj-production.up.railway.app/api/next-tracking-number

Request -> {
    "origin_country_id" : "MY",
    "destination_country_id":"ID",
    "weight":"1.234",
    "created_at":"2018-11-20T19:29:32+08:00",
    "customer_id":"de619854-b59b-425e-9db4-943979e1bd49",
    "customer_name":"RedBox Logistics",
    "customer_slug":"redbox-logistics"
}

**To test in postman use below collection**

src/main/resources/TrackingNumberAPI.postman_collection

