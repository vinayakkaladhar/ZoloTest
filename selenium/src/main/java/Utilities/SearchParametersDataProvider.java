package Utilities;

import org.testng.annotations.DataProvider;

public class SearchParametersDataProvider {

    @DataProvider(name = "searchCombinations")
    public static Object[][] searchCombinations() {
        return new Object[][]{
                {"Zolostays", 3, 4 ,2 ,3},
                {"Best PG in India", 1, 2 ,5 ,6},
                {"Managed PG", 19, 3 ,3 ,2},
                {"Zolo Career", 2, 5 ,2 ,1}
        };
    }
}
