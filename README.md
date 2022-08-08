# Africa-Teambox-Model
This is a private repository for the africa teambox model

Our sample application if named Tweekles - it is sort of a mini Twitter clone with not much functionality.

The features / use-cases it should support (in the given order) are as follows:

**Add Post**

Data supplied by the customer:
* message (limited to 500 characters)

Data added by the backend service:
* ID (could be numeric, but a UUID is recommended)
* author (UserName)
* postedAt (timestamp)

**List Posts**

* list an overview of all posts, showing:
  * author, message (shortened to 100 characters), age of the post in days and hours, number of likes
* no pagination for now, just limit to 15? posts
  
**Show post details**

* show all the details as in the "list post", but the full message
* additionally has a like or unlike button, depending on whether the user has already liked the post