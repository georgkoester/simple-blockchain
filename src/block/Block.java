package block;

import encript.SHA256;

public class Block
{
    // Header
    private int height;
    private long timestamp;
    private String previous_hash;
    private String hash;
    private HashCashInfo hashCashInfo;
    // Header END

    private BlockData data;

    public Block( int height, String previous_hash, long timestamp, HashCashInfo hashCashInfo, BlockData data )
    {
        this.height = height;
        this.timestamp = timestamp;
        this.previous_hash = previous_hash;
        this.hashCashInfo = hashCashInfo;

        this.data = data;
    }

    public String getBlockContentHash()
    {
        return hashBlockContent(getHeight(), getPrevious_hash(), getTimestamp(), getData());
    }

    public static String hashBlockContent( int height, String previous_hash, long timestamp, BlockData data )
    {
        // most header fields and data
        String content = height + previous_hash + timestamp + data.toString();
        return SHA256.toSha256(content);
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight( int height )
    {
        this.height = height;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp( long timestamp )
    {
        this.timestamp = timestamp;
    }

    public String getPrevious_hash()
    {
        return previous_hash;
    }

    public void setPrevious_hash( String previous_hash )
    {
        this.previous_hash = previous_hash;
    }

    public String getHash()
    {
        return getHashCashInfo().getHash();
    }

    public void setHash( String hash )
    {
        this.hash = hash;
    }

    public BlockData getData()
    {
        return data;
    }

    public void setData( BlockData data )
    {
        this.data = data;
    }

    public HashCashInfo getHashCashInfo()
    {
        return hashCashInfo;
    }

    @Override
    public String toString()
    {
        return "Block{" +
                "height=" + height +
                ", timestamp=" + timestamp +
                ", previous_hash='" + previous_hash + '\'' +
                ", hash='" + hash + '\'' +
                ", hashCashInfo=" + hashCashInfo +
                ", data=" + data +
                '}';
    }
}
