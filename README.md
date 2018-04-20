# DatapathAppAndroid
An educational datapath application for CS 3339 hosted on Android

Okay so at the moment there's basically just the menu system for starting up the program. There's layouts/containers/buttons that navigate you to the datapath based on what you want to see. This is called the "Main Activity"

[Picture 1](https://gyazo.com/eb7606f824a886f09ef0090149d00bd4)

"Learn More" just takes you to an educational document for datapaths

The rest of the things send you to "Datapath Activity", which is where we will have the datapath.
The instructions send their ID to the next screen, so for example clicking the "Add" bar will send id of 0 to the datapath activity. Subtract will send 1, and so on. We will use this to display different types of datapaths based on the instruction type (ALU, branch, etc)

Clicking on "Try it now" sends a -1 to the datapath activity, which we will use to "test" the user as per the request of the professor. So the activity will display an instruction name, and the user must build the correct datapath for that instruction.


How the datapath activity will work:
- All of the main components will be there by default (Registers, ALU, Memory, Controller) via sets of images (I tried doing one giant image, didnt work out)
- The arrows will be there, but will essentially be at like 25% opacity or something, and clicking on them will make them "a part" of the system (so 100% opacity). So the answer the user gives will be correct if the correct arrows are highlighted.
- So basically theres += 20 image buttons that are responsible for selecting stuff.
- If the user navigated to the datapath activity by clicking on an instruction (IE the information sent is > -1), it will just have the correct paths at 100% opacity based on the instruction and the user wont be able to click it.

Honestly I dont think this is difficult to implement, it will just be time consuming to make the images required in the correct size for the phone. We should base the images off [this picture](https://gyazo.com/0620418fd1841b2e3e8a9f5c3cfe28a3), as I think it works the best for what we're dealing with in terms of space and ease of access. 

Worst case scenario I write the code because I've somewhat familarized myself with Android Studios / the XML stuff, but if you want to try to learn that (most of the annoying stuff should be next to done) that works for me too.

As of 4/19 the source consists of all the XMLs pertaining to the layout of picture 1 as shown, and the code for merging all of that together and getting buttons to do the things.
