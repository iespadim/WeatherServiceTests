##how to run:

using gradle: cleanTest :test--tests "tests.services.WeatherService_getTemps"

made using java 11, lombok and JUNIT

## sample output:

  

     Testing started at 16:22 ...
         Task :cleanTest UP-TO-DATE
         Task :compileJava
         Task :processResources NO-SOURCE
         Task :classes
         Task :compileTestJava
         Task :processTestResources NO-SOURCE
         Task :testClasses
         Task :test
    
    Request method:	GET
    Request URI:	https://api.interzoid.com/getweather?city=Tampa&license=718abf54b490be4b2859157beaf2fa54&state=TX
        Proxy:			<none>
        Request params:	<none>
        Query params:	city=Tampa
        				license=718abf54b490be4b2859157beaf2fa54
        				state=TX
        Form params:	<none>
        Path params:	<none>
        Headers:		Accept=*/*
        Cookies:		<none>
        Multiparts:		<none>
        Body:			<none>
        HTTP/1.1 404 Not Found
        Date: Mon, 30 Mar 2020 19:22:29 GMT
        Content-Type: text/plain; charset=utf-8
        Content-Length: 34
        Connection: keep-alive
        Access-Control-Allow-Origin: *
        X-Content-Type-Options: nosniff
        
        City and state location not found
        
        Request method:	GET
        Request URI:	https://api.interzoid.com/getweather?city=&license=718abf54b490be4b2859157beaf2fa54&state=
        Proxy:			<none>
        Request params:	<none>
        Query params:	city=
        				license=718abf54b490be4b2859157beaf2fa54
        				state=
        Form params:	<none>
        Path params:	<none>
        Headers:		Accept=*/*
        Cookies:		<none>
        Multiparts:		<none>
        Body:			<none>
        HTTP/1.1 400 Bad Request
        Date: Mon, 30 Mar 2020 19:22:31 GMT
        Content-Type: text/plain; charset=utf-8
        Content-Length: 53
        Connection: keep-alive
        Access-Control-Allow-Origin: *
        X-Content-Type-Options: nosniff
        
        Insufficient parameters: city and state are required
        
        Request method:	GET
        Request URI:	https://api.interzoid.com/getweather?city=Round%20Rock&license=718abf54b490be4b2859157beaf2fa54&state=TX
        Proxy:			<none>
        Request params:	<none>
        Query params:	city=Round Rock
        				license=718abf54b490be4b2859157beaf2fa54
        				state=TX
        Form params:	<none>
        Path params:	<none>
        Headers:		Accept=*/*
        Cookies:		<none>
        Multiparts:		<none>
        Body:			<none>
        HTTP/1.1 200 OK
        Date: Mon, 30 Mar 2020 19:22:32 GMT
        Content-Type: application/json
        Content-Length: 212
        Connection: keep-alive
        Access-Control-Allow-Origin: *
        
        {
            "City": "Round Rock",
            "State": "TX",
            "TempF": "68.0",
            "TempC": "20.0",
            "Weather": "Light Rain Fog/Mist",
            "WindMPH": "0.0",
            "WindDir": "North",
            "RelativeHumidity": "96",
            "VisibilityMiles": "2.00",
            "Code": "Success",
            "Credits": "21"
        }
        WARNING: An illegal reflective access operation has occurred
        WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass (file:/C:/Users/icaro/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy/2.4.15/74b7e0b99526c569e3a59cb84dbcc6204d601ee6/groovy-2.4.15.jar) to method java.lang.Object.finalize()
        WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
        WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
        WARNING: All illegal access operations will be denied in a future release
        BUILD SUCCESSFUL in 14s
        4 actionable tasks: 3 executed, 1 up-to-date
        16:22:28: Tasks execution finished ':cleanTest :test --tests "tests.services.WeatherService_getTemps"'.

