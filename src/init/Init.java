package init;

import chain.Blockchain;
import miner.Miner;

import java.security.DigestException;
import java.security.NoSuchAlgorithmException;

public class Init
{

    public static void main( String[] args ) throws NoSuchAlgorithmException, DigestException
    {
        Blockchain chain = new Blockchain();

        // start a miner:
        Miner miner1 = new Miner(chain);
        miner1.start();

        Miner miner2 = new Miner(chain);
        miner2.start();
    }
}
