# SpringBootEndpoints
SpringBootEndpoints experiment


Basically, the goal would be to use a different MappingJackson2HttpMessageConverter containing
a different Jackson ObjectMapper that uses a Jackson MixIn to rename(in the Json) the id to priceId
in the 2nd Controller.

What a call to the first controller would do :

http://localhost:8080/controller1/price

{
       **id**: "id",
       description: "Description"
}

What a call to the second controller would do :

http://localhost:8080/controller2/price

{
        **priceId**: "id",
        description: "Description"
}
