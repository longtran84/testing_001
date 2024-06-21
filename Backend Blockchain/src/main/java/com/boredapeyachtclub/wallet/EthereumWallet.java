package com.boredapeyachtclub.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;

/**
 * Java Projects and Tools
 *
 *     Hyperledger Besu (Pantheon) (Ethereum Client)
 *     Web3J (Library for Interacting with Ethereum Clients)
 *     Eventeum (Event Listener)
 *     Mahuta (IPFS Dev Tools)
 */
public class EthereumWallet {
    private static Logger logger = LoggerFactory.getLogger(EthereumWallet.class);
    /**
     * Checking Your Balance on the Ethereum Blockchain
     * address = "0xbc4ca0eda7647a8ab7c2061c2e118a18a936f13d";
     * @return
     */
    private final BigDecimal getBalanceEthereum(String address) {
        final Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/220c6a77dfe540079c59911d0ed5d710"));
        try {
            BigInteger blockNumber = web3.ethBlockNumber().send().getBlockNumber();
            System.out.println("Latest Ethereum block number: " + blockNumber);
            EthGetBalance balanceResponse = web3.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
            if (balanceResponse.hasError()) {
                logger.error("Error occurred: " + balanceResponse.getError().getMessage());
            } else {
                BigInteger balanceWei = balanceResponse.getBalance();
                logger.info("Balance in Wei: " + balanceWei);
                String balanceEther = Convert.fromWei(balanceWei.toString(), Convert.Unit.ETHER).toPlainString();
                logger.debug("Balance in Ether: " + balanceEther);
                return Convert.fromWei(balanceWei.toString(), Convert.Unit.ETHER);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        logger.debug("Printing variable value: ");
        System.err.println("Enter your Contract address: ");
        Scanner sysIn = new Scanner(System.in);
        while (sysIn.hasNextLine()) {
            String contractAddress = sysIn.nextLine();
            logger.info("contractAddress " + contractAddress);
            logger.info("Balance in Ether: " + new EthereumWallet().getBalanceEthereum(contractAddress));
            System.err.println("Enter your Contract address: ");
        }
    }
}
