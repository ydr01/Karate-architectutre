function() {
    var env = karate.env; // get system property 'karate.env'
    var locale = karate.properties['locale']; // get system property 'karate.locale'
    

    if (!env) {
        env = 'qa'; //intelligent default
    }
    
    if(!locale){
    	locale = 'en_IN';
    }
    
    var config = {
        env : env,
		locale : locale,
		baseUrlPB : 'https://egov-micro-' + env + '.egovernments.org',
		baseUrlUK : 'https://uttarakhand-' + env + '.egovernments.org',
		userPostUrl : 'https://jsonplaceholder.typicode.com/posts',
		userGetUrl : 'https://jsonplaceholder.typicode.com/posts/1',
		userPutUrl : 'https://jsonplaceholder.typicode.com/posts/1',
		userDeleteUrl : 'https://jsonplaceholder.typicode.com/posts/1',
		retryCount : 30,
        retryInterval : 10000 //ms
    };

    if(env.equals('qa')){
    	print("came inside the qa block.\n");
        
        }
        
    else if(env.equals('dev')){
    	print("came inside the dev block.\n");
  } 

    karate.log('karate.env:', env);
    karate.log('locale:', locale);
    karate.configure('readTimeout', 120000);
    

    return config;
}
