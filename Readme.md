# Steps To Run The app
### Required Tools 
    - My sql dataBase is connected 
    - Script available in src/main/resource 
	
	
### Step 1 
Run the springboot application

# TO Save all data in to database Use as follow
####1 POST -> http://localhost:8080/api/v1/sms/
  Sample payload ->
  [{"id":1,"city":"Neftegorsk","start_date":"4/13/2013","end_date":"5/18/2013","price":"55.82","status":"Seldom","color":"#fd4e19"},
{"id":2,"city":"Lancai","start_date":"5/19/2012","end_date":"11/29/2014","price":"22.49","status":"Yearly","color":"#ff5055"},
{"id":3,"city":"Hekou","start_date":"8/28/2011","end_date":"4/7/2014","price":"9.48","status":"Often","color":"#903761"},
{"id":4,"city":"Ballymahon","start_date":"8/19/2013","end_date":"8/3/2015","price":"47.53","status":"Often","color":"#cd387d"}]

####2 all data is present in data.json file in resource folder copy the data and pass it to Step 1 payload 

### 3 Once data loaded run the UI app {SmsReactApp} present in the Repository






