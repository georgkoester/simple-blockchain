package block;

import miner.Hash;
import miner.PoW;

public class BlockUtil
{

    public static Block generateGenesisBlock()
    {
        int index = 0;
        long timestamp = System.currentTimeMillis();
        String previous_hash = "0";

        BlockData data = new BlockData("burokuru-shuriken");

        final HashCashInfo hashCashInfo = Hash.generateStatic(1, data.toString());
        return new Block(index, previous_hash, timestamp, hashCashInfo, data);
    }
}
