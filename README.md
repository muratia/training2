# Training version 3

## Endpoints
 
|  Endpoint	| HTTP Method |  Response	|  Exception |
|---	|---	|---	|---	| 
|  http://127.0.0.1:8080/dataitem/output/?quesition 	|  GET |  returns the output based on the question provided 
|

Die Frage kann als eine, zwei oder drei durch einen vertikalen Teiler | getrennte Fragen übergeben werden

Zum Beispiel.

http://127.0.0.1:8080/dataitem/output/?quesition=Welcher Politiker hielt im Jahr 2013 die meisten Reden
http://127.0.0.1:8080/dataitem/output/?quesition=Welcher Politiker hielt die meisten Reden zum Thema ”Innere Sicherheit”
http://127.0.0.1:8080/dataitem/output/?quesition=Welcher Politiker sprach insgesamt die wenigsten Wörter
http://127.0.0.1:8080/dataitem/output/?quesition=Welcher Politiker hielt im Jahr 2013 die meisten Reden|Welcher Politiker hielt die meisten Reden zum Thema ”Innere Sicherheit”|Welcher Politiker sprach insgesamt die wenigsten Wörter


Der Antwort den Ersten Frage ist     

{  
    "mostSpeeches": null,  
    "mostTalkedTopic": null,  
    "leastWordy": null  
}  

Der Antwort für den Zweiten Frage ist  
 
{  
    "mostSpeeches": null,  
    "mostTalkedTopic": "Alexander Abel",  
    "leastWordy": null  
}  

Der Antwort für den Dritten Frage ist  

{  
    "mostSpeeches": null,  
    "mostTalkedTopic": null,  
    "leastWordy": "Alexander Abel"  
}  

Der Antwort für den kombinierten Fragen ist

{  
    "mostSpeeches": null,  
    "mostTalkedTopic": "Alexander Abel",  
    "leastWordy": "Alexander Abel"  
}  

