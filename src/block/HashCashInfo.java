package block;

public class HashCashInfo
{
    private String hash;
    private String stamp;

    public HashCashInfo( String hash, String stamp )
    {
        this.hash = hash;
        this.stamp = stamp;
    }

    public String getHash()
    {
        return hash;
    }

    public String getStamp()
    {
        return stamp;
    }

    @Override
    public String toString()
    {
        return "HashCashInfo{" +
                "hash='" + hash + '\'' +
                ", stamp='" + stamp + '\'' +
                '}';
    }
}
