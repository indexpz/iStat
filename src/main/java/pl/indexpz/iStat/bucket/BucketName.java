package pl.indexpz.iStat.bucket;


public enum BucketName {
    PROFILE_IMAGE("istat.pl");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
