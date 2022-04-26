package api;

public class Urls {
   protected static final String LOGIN = "/v1/login";
    protected static final String ROOT_FOLDER = "/api/metagenid/v2/files?breadcrumbs=1&offset=0&limit=1000&_=1622700773180";
    protected static final String SPECIFIC_FOLDER = "/api/metagenid/v2/files?breadcrumbs=1&offset=0&limit=1000&folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773180";
    protected static final String FILES_COUNT_URL = "/api/metagenid/v2/files/count?folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773179";
    protected static final String FILES_RESULT_URL_GET_RUN = "/api/metagenid/v1/files/7f4c7326-0a4e-4b56-a8d0-8ce002191672/runs?_=1622700773181";
    protected static final String FILES_RESULT_URL_GET_ANALYSES = "/api/metagenid/v1/runs/437ef8e4-b595-4fd8-a2f5-64221831e925/analysis?filter=total&_=1622700773184";
    protected static final String FILES_RESULT_URL_GET_ARTIFACTS = "/api/metagenid/v1/runs/437ef8e4-b595-4fd8-a2f5-64221831e925/artifacts?_=1622700773185";
}
