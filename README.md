SNSDTablet
==========

The assignment is to convert this app into a tablet friend app.
At the moment it scales up fine, and since it's just text, it is pretty acceptable.
But that's not what we want.

Do what ever you want to it, even make it an actual app or something.
But show that you can design a tablet layout that not only looks good, but functions just as well.

http://developer.android.com/training/basics/fragments/fragment-ui.html
http://developer.android.com/guide/practices/tablets-and-handsets.html
http://developer.android.com/design/patterns/multi-pane-layouts.html

These should point you in the right direction, I recommend you at least skim over them.
It might also be wise to get some sort of grasp on fragment, since that's what the app is made up of (This app and the SSF app).

There is no due date, but just don't abandon this or take forever.

Changelog:  
**(17/1/14)**
Tada, finally got this thing to even function properly. Shall start getting work done from this point on. MY FIRST COMMIT! <3

**(25/1/14)**  
Managed to fix the orientation change problem which causes the app to crash. Took a VERY long time to find for the solution but now it's resolved. Now that the app is basically 'bugless', i'll begin to play around with the fragments next. (Finally)

**(15/2/14)**  
Still doing heavy research on different fragment layouts. In the meantime, enabled screen compatibility mode if it makes any sense, haha.

**(23/2/14)**  
Tried finishing the standard layouts today. Didn't turn out as planned, but I know i'm almost there.

**(24/2/14)**  
Alright, fixed that bug. The problem was `getArguments().getString("name")` returning null because, well, we never set that argument when the fragment was being created in `activity_main.xml` (and AFAIK there is no way to do so in XML).
The solution was to replace that fragment in `activity_main.xml` with a `FrameLayout` and assign it the id of `content` so we can later replace it with a fragment (That has the arguments set).

Of course we need to set a default fragment to sit next to the list other wise it'll look strange. To solve this, I went into `MainActivity.java` and created a new `ContentFragment`, set it's arguments and replaced that `FrameLayout` (with id `content`) with the newly created `ContentFragment`.

Something else that needed attention (that you probably didn't see since the app crashed...) was the parent view in `activity_main`. It's a `FrameLayout` because originally it was just by itself with no children and played the role of the `FrameLayout` mentioned earlier. Obviously this is not the case anymore, so I changed it to `LinearLayout` which allowed us to use the `android:orientation` attribute.  
I then set the gravity of the child views so that they would 'auto' arrange them selves to the two-pane layout (Thanks Android Studio for that advice <3).

***What's left?***  
From here on out it should be fairly simple. All you need to do is make the whole app work on both phones and tablets.  

* For phones, it should look like it did originally: Single view where it swaps out the fragment
* For tablet, pretty much how it looks now, but with a few design tweaks.

Basing on what I've read on this, it's all a matter of creating different layout folders for the different screen types and slight modification in Java.

After you think you've completed it, I'll look at it and tell you what I think. After that, you'll have free reign over the Soshified repo!

**(23/3/14)**
Oh god, been fiddling around with the same bug for weeks and I can't find the culprit. My plan was to create a layout to handle the device when in portrait orientation, and only splitting into 2 fragments when in horizontal. From my eyes, everything looks close to perfect already. HELP ME PLS.

**(24/3/14)**
It's actually very trivial lol. One little secret: When trying to find a bug, try to explain it to an innanimate object that has no idea about the code. Go through every method and every class, and explain it to the object. Chances are, you will find something that you overlook because of tunnel vision. If you think about it, it's a pretty useful technique.

That aside, I'll let you look at the code. But we weren't checking for orientation in the MainActivity class and as such we were forcing the ContentView into a view that simply didn't exist at the time (because we were using the wrong layout file, but if using the version as of this commit, you can try rotating your device and then getting into the app).

And fair warning: With your detail activity stuff, it will crash.

I fixed the bug, and one other thing (I commented it in).

From here, it looks like you've got one or two things left. If you try rotating the app, it won't change to the layout that was built for it (it'll resize it's current layout), I purposely left this alone and see if you can find it :merong:. But it's a really simple fix, you need to remove a word in the manifest.