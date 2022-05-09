import applications.api.ApiClient;
import conf.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FolderRequestsTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    @BeforeClass
    public void beforeFolderRequestsTests() {
        try {
        ApiClient.sendLoginToGetToken();
        }
        catch (Exception e){
            LOGGER.error("Login Failed");
        }
    }

    @Test(description = "Verify that the root folder is not empty")
    public void testRootFolderSuccessful() {

        try {
            assert !ApiClient.filesRootFolderRequest().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Request Failed");
        }
    }

    @Test(description = "Verify that the file specific folder is not empty")
    public void testFileSpecificFolderSuccessful() {

        try {
            assert !ApiClient.filesSpecificFolderRequest().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Request Failed");
        }
    }

    @Test(description = "Verify that the count is not 0")
    public void testCountMoreThenZeroSuccessful() {

        try {
            assert !ApiClient.filesCountRequest().equals("0");
        }
        catch (Exception e){
            LOGGER.error("Request Failed or count <= 0");
        }
    }

    @Test(description = "Verify that the runs response is not empty")
    public void testRunsRequestsSuccessful() {

        try {
            assert !ApiClient.filesResultsGetRunsRequest().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Request Failed");
        }
    }

    @Test(description = "Verify that the analyses response is not empty")
    public void testAnalysesRequestsSuccessful() {

        try {
            assert !ApiClient.filesResultsGetAnalysesRequest().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Request Failed");
        }
    }

    @Test(description = "Verify that the artifacts response is not empty")
    public void testResultsGetArtifactsRequestSuccessful() {

        try {
            assert !ApiClient.filesResultsGetArtifactsRequest().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Request Failed");
        }
    }
}
