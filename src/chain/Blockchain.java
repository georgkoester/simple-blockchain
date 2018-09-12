package chain;

import block.Block;
import block.BlockUtil;
import miner.PoW;

import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Blockchain
{

    private static ArrayList<Block> blockchain;

    public Blockchain()
    {
        initBlockchain();
    }

    public synchronized Block getLatestBlock()
    {
        return blockchain.get(blockchain.size() - 1);
    }

    public synchronized Block getBlockAtHeight( int height )
    {
        return blockchain.get(height);
    }

    public synchronized int getHeight()
    {
        return blockchain.size();
    }

    public synchronized void submitNewBlock( Block new_block ) throws InvalidNewBlockException
    {
        if (!isNewBlockValid(new_block)) {
            throw new InvalidNewBlockException();
        }
        blockchain.add(new_block);
    }

    public boolean isNewBlockValid( Block new_block )
    {
        boolean is_valid = true;
        Block previous_block = getLatestBlock();

        if (previous_block.getHeight() != new_block.getHeight() - 1)
            is_valid = false;

        else if (!previous_block.getHash().equals(new_block.getPrevious_hash()))
            is_valid = false;

        else
            is_valid = PoW.validate(new_block.getHash());

        // validate content here, too

        return is_valid;
    }

    private synchronized void initBlockchain()
    {
        blockchain = new ArrayList<>();
        blockchain.add(BlockUtil.generateGenesisBlock());
        System.out.println("Genesis created: " + blockchain.get(0));
    }

}
