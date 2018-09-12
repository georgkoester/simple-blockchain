package miner;

import block.BlockData;
import block.BlockUtil;
import block.HashCashInfo;

import java.security.DigestException;
import java.security.NoSuchAlgorithmException;

public class PoW
{


    private static final int NUM_BITS = 16;

    public static HashCashInfo generateHash( String blockContentHash )
    {
        return Hash.generateStatic(NUM_BITS, blockContentHash);
    }

    public static boolean validate( String hash )
    {
        return Hash.valid(NUM_BITS, hash);
    }
}
