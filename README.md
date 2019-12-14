1.[x] Input User Names to play with -> List 
    -[x] Standard :','
    -[x] Min player : 2
    -[x] Max player : 8
    -[x] Exception
        -[x] blank

2.[x] Input each betting money -> List
    -[x] type : double
    -[x] Exception
        -[x] 0 OR Minus
        -[x] Not Double
        -[x] blank
        
3.[x] 1+2 -> make Player & Dealer
    - make both
    - make total betting money

4. game start

5. give each users two cards
    - if) some user have blackjack (ace -> regard as 11)
        - if) dealer have black jack (ace -> regard as 11)
            - the player : betting money
            - others : -betting money
            - dealer : += -betting money
        - the player : betting money * 1.5
        - others & dealer : play game continue

6.[x] can have one more && ask everyone to want to get one more card
    -[x] can have one more
        -[x] ace -> regard as 1
    -[x] give one more card
    -[x] print the cards
    -[x] Input Exception
        -[x] Not Y / N

7.[x] dealer sum of cards >= 16
    -[x] give one more card to dealer (ace -> regard as 11)
    -[x] if(!burst)
        ace -> regard as 11

8.[x] dealer sum of cards <= 17
    -[x] stop        

9.[x] print all cards with dealer and players

10.[x] calculate profits and print
                    