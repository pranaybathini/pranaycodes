
![Understanding creation and definition of seed phrase, private key and public key in blockchain crypto wallets.png](https://images.hive.blog/DQmS54WL8ESWAFc1YMNojCbZBnxPK9eY5CRnb8V6AhUwu5y/Understanding%20creation%20and%20definition%20of%20seed%20phrase,%20private%20key%20and%20public%20key%20in%20blockchain%20crypto%20wallets.png)

It is only repetitive to say how important it is to understand the seed phrase also called as recovery phrase or secret recovery phrase or back up phrase , private key and public key. 

Whenever you create a crypto wallet, you might have warned to keep the secret phrase  and private key  safe and never share with anyone. In this blog post, I would like to explain about the three terms and the journey of seed phrase to your wallet address in most clear way possible. 

---

# Seed Phrase
Blockchain wallets have a **master key** made up of unique 12 word phrase generated when you create a wallet on blockchain. You would be given a unique 12 word secret phrase when you create your metamask wallet or bitcoin wallet or any wallet which is managed by you. 

You only protect your secret phrase, your funds are stored on the blockchain. If you lose your secret phrase, your funds are lost too. 

It is always advisable to store your secret phrase safely - write in diary, engrave on steel plates, write in cryptic form which only you can understand are some options to keep secret phrase. Never share your secret phrase with one. Sharing your secret phrase is like handing over keys to your house. 

## Example seed phrase  - 12 words
```zero small sunny grape dose weasel image bind crack soap thunder theme```
 
---

# Private key
If we apply the house analogy here, a private key is the key to your locker room in your house. Suppose you have multiple locker rooms in your house, your seed phrase is the master key which could open all your locker rooms and private key is the key which could open a specific locker room.

We derive private key from our seed phrase. They are infinite number of private keys that could be derived from the seed phrase.

Private keys are used for authentication and encryption. We sign all our transactions with our private keys. 

---

# Public Key
Again if we refer to our house analogy, a public key for the public identification of your locker room in your house. It is to receive digital assets. All your assets are stored on the blockchain.  But only the people with the private key could access the assets stored on the blockchain. 

Again, you public wallet address is derived from your public key which in turn derived from private key. 

 ---

# How can blockchain verify that the transactions are signed with your private key only?
When we do any transaction, we sign the transaction with our private key which would generate a signature. When it goes to blockchain, the blockchain has a crypto-algorithm which can take this signature and deduce your public address from it and it compares to the public address the transaction is originating from and if both match, then the transaction will be allowed to execute. 

This confirms the of the assets. 

We can create the public key from the private key but not vice versa which is private key from public key. This is what makes crypto. 

---

# Creation of Seed Phrase
 

Secret phrases are defined by the [BIP-39 specification](https://github.com/bitcoin/bips/blob/master/bip-0039.mediawiki). This is also called Brain wallet which is a means of deriving the secret key alone from the seed phrase. 

To create a 12 word seed phrase, we will need 128 bit entropy which is random 0's and 1's. We then apply SHA-256 algorithm and then take entropy/32 which is 128/32 = 4 bits from the SHA generated and add it to the entropy.  Now we will get 132 bits and we will divide it into 11 bit groups like below and convert them to decimals like below.
```
11111011000 10101111111 00000111100 10001000001 10111011010
2008        1407        60          1089        1498
00011000101 00000001111 01001010111 11101011100 00111111110
197         15          599         1884        510
10000111111 10111100100
1087        1508
```
BIP-39 specification will contain many word lists and each list contain 2048 words(0-2047). We will refer a random list and reach upon the 12 word phrase like below.

```pond mass tray vicious digital when pool panda renew mansion sunset depart```

 
---

# Seed Phrase to Private key
 

There is no randomness will be used to generate private keys from seed phrase as we need it to be deterministic. Regardless of how many times we apply the cryptography algorithm to seed phrase, same private keys need to be generated.

 ---

## Steps
* A seed is generated from seed phrase by using a key derivation function called [PBKDF2 Function](https://en.wikipedia.org/wiki/PBKDF2) which is also known as **Password-Based Key Derivation Function 1 and 2**.  

* It gives a 512 bit long seed like 
```d1f8cfb79acea59c03deb87b1ef1ef88f94974b7fe82ad7cb58f75a155ca5457b3b482f9bf286099bb0dbdd4ce12d811aab3f8520c0b5279e9a1647edf2cdc0d```
* This seed is used again and passed to PBKDF2 function to generate a 512-bit long key. From this key, we can derive many different child keys. This 512 bit key is called master key. 
* The first 256 bits are used as child keys and last 256 bits used as chain code to make the child keys not to introduce entropy and both of these are used to create an extended private keys.  The generation process of child keys are not explained as it requires very higher level mathematics.
* We generate the public keys from these private keys using elliptic curve cryptography algorithm known Elliptic Curve Digital Signature Algorithm (ECDSA)
* In case of bitcoin,  ```publicKey = privateKey * G ``` where G is a constant on elliptic curve is used. Bitcoin uses **secp256k1’s elliptic curve**. 

We can generate as many private keys. We need to pass index every time. Our primary wallet is at index 0. 


![child tree.png](https://images.hive.blog/DQmZYSwAYfDUHjLHUNdcNdASVTuJwvr9Tyw9fYs4gWkSBq4/child%20tree.png)

---

# Private Key to Public Key
We generate the public keys from these private keys using elliptic curve cryptography algorithm known Elliptic Curve Digital Signature Algorithm (ECDSA). Ethereum uses [secp256k1](https://www.secg.org/sec2-v2.pdf) to generate public keys where public keys are a point on Elliptic curve.

---

# Public Key to Public Wallet address 
In Ethereum, we apply keccak-256 hash function over public key and we will take last 20 bytes and append 0x to it. 

## Example 

```0xd8E5A11616c45A0E9c76Ef42b0e3ef85B6c12981```
 
---

# BIP39 Mnemonic Code
This last part is a bonus. This will be helpful in recovering your private keys to the accounts you lost  but you remember the seed phrase. 

Visit [mnemonic code converter](https://iancoleman.io/bip39/), paste your seed phrase in the site and select the appropriate coin. For safety, load the site and use it in offline mode, it will function. It will generate all the possible public and private keys like below.


![bip39.png](https://images.hive.blog/DQmYovUUJScYLouURiCUfpBj9tWEhceFq8tYb4nW1qycyfN/bip39.png)

Thanks for reading. 
