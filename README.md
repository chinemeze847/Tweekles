# Africa-Teambox-Model
This is a private repository for the africa teambox model

## Our sample application is named Tweekles - it is sort of a mini Twitter clone with not much functionality.

Miro board: https://miro.com/app/board/uXjVOg1foJ8=/

The features / use-cases it should support (in the given order) are as follows:

**Add Post**

Data supplied by the customer:
* message (limited to 500 characters)

Data added by the backend service:
* ID (could be numeric, but some unique ID like a UUID is recommended)
* Author (UserName)
* postedAt (timestamp)

**List Posts**

* list an overview of all posts, showing:
  * author, message (shortened to 100 characters), age of the post in days and hours, number of likes
* sort by timestamp (newest first)
* no pagination for now, just limit to 15? posts
  
**Show post details (by PostID)**

* show all the details as in the "list post", but the full message
* additionally has a like or unlike button, depending on whether the user has already liked the post

**Like a Post**

* users can't like their own Posts
* users can only like a Post once

* PostID
* UserName
* timestamp


**Unlike a Post**

* users can only unlike a Post they have liked before (automatically excludes own Posts)

* PostID
* UserName
* timestamp
