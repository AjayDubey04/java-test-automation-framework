package testng.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

    @DataProvider(name = "Hello")
    public Object[][] getData() {
        // Define your test data as a two-dimensional array
        return new Object[][] {
            {"username1", "password1"},
            {"username2", "password2"},
            // Add more sets of data as needed
        };
    }
    
   
    @DataProvider()
    public Object[][] Data() {
        // Define your test data as a two-dimensional array
        return new Object[][] {
            {"username1", "password1"},
            {"username2", "password2"},
            // Add more sets of data as needed
        };
    }
}


 class LoginTest {

    @Test(dataProvider = "Hello",dataProviderClass = TestDataProvider.class)
    public static void testLogin(String username, String password) {
        // Test logic using the provided username and password
        System.out.println("Logging in with username: " + username + " and password: " + password);
        // Your test validation/assertions go here
    }
    
    @Test(dataProvider = "Data",  dataProviderClass = TestDataProvider.class)
    public static void login() {
        // Test logic using the provided username and password
        System.out.println("Logging in with username:   and password: ");
        // Your test validation/assertions go here
    }
}

