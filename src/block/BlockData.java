package block;

public class BlockData
{

    private String data;

    public BlockData( String data )
    {
        this.data = data;
    }

    public String getData()
    {
        return data;
    }

    public void setData( String data )
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "BlockData{" +
                "data='" + data + '\'' +
                '}';
    }
}
