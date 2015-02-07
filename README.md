# WayShopperX

This Project helps the users to find the fastest way in the store to shop their items. 

Currently, there are only five items in the list which are:
Apple, Juice, Meat, Eggs and Nuts

## Steps to use the Way Shopper
#### Home Screen
We have 3 options here:
..* Shopping List
..* Inside Store Way finder
..* Outside Store Way finder

![alt text](http://hapoojoon.com/wayshopperimages/home.png)


#### 1. Shopping List

This section of the app can be used as a shopping list when we're certain regards the items in the store and we are only interested to have a record of the items that we are buying.
User can add any item to his/her list and app doesn't ristrict the user from entering invalid items. (Unlike other sections where there are restrictions)

![alt text](http://hapoojoon.com/wayshopperimages/List1.png)   ![alt text](http://hapoojoon.com/wayshopperimages/List2.png)


#### 2. Find Way inside the store.

Now we first have to find the store we like to go. Therefore, user first provides the zipcode of where he wishes to go shopping and then app provides the stores on that zipcode. (in this version of the app, I have used fake data. So, we are assuming that we have one store with only few items to buy)

![alt text](http://hapoojoon.com/wayshopperimages/shopAdress1.png)   ![alt text](http://hapoojoon.com/wayshopperimages/shopAdress2.png) ![alt text](http://hapoojoon.com/wayshopperimages/shopAdress3.png)   

Then we are directed to the shopping list which only accepts the "available" items in that particular store. Therefore if the user enters an item which does not exist in the list, the app won't accept the entry and asks the user to enter the valid item. ( Future Improvements: I will provide a popop list which user observes which items are available rather than testing if the app accepts the item or not).

![alt text](http://hapoojoon.com/wayshopperimages/shopList1.png)   ![alt text](http://hapoojoon.com/wayshopperimages/shopList2.png) ![alt text](http://hapoojoon.com/wayshopperimages/shopList3.png)   

After submitting the list, user will be directed to the page where there is a map including the best path to take to get the items as fast as possible.

![alt text](http://hapoojoon.com/wayshopperimages/map.png)

#### Way finding algorithm
Basically this algorithm is finding the shortest path in a graph when we "have to" pass certain nodes. To make this happen, I looked into algorithms such as "A Star Algorithm" and "Dijkstra's Algorithm". I later chose to use "Dijkstra's Algorithm" since it was easier for me to understand and implement. 

What happens is that each item has a node in the graph and those items which user picks, goes inside a list. Then, my program searches for the shortest path available to any of these items. Then that item goes off the list and from that point new dijsktra's algorithm is run for finding the shortest path to the next item and so on.

This code is written in JavaScpript and the map is located on my cloud and it is run as a WebView html screen.

I have dedicated a repository just for this algorithm and how it works. You can learn more about it by clicking [here](https://github.com/samramez/Shortest_path_between_multiple_nodes_in_graph) .


