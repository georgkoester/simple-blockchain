package miner;

import block.Block;
import block.BlockData;
import block.HashCashInfo;
import chain.Blockchain;
import chain.InvalidNewBlockException;

public class Miner extends Thread
{
    private final Blockchain chain;

    public Miner( Blockchain blockchain )
    {
        this.chain = blockchain;
    }

    public void run()
    {
        for (int i = 0; i < 100000; i++) {

            BlockData data = new BlockData("Data_" + i);

            Block block = generateNewBlock(chain.getLatestBlock(), data);

            try {
                chain.submitNewBlock(block);
                System.out.println("" + this + " succeeded in pushing a block: " + block);
            } catch (InvalidNewBlockException e) {
                System.out.println("" + this +": Darn, was too slow. Block apparently outdated.");
            }
        }
    }

    public Block generateNewBlock( Block currentBlock, BlockData data )
    {
        Block previous_block = currentBlock;
        int height = previous_block.getHeight() + 1;
        long timestamp = System.currentTimeMillis();
        String previous_hash = previous_block.getHash();
        HashCashInfo hash = PoW.generateHash(data.toString());

        return new Block(height, previous_hash, timestamp, hash, data);
    }
}
