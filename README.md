# Powerful Stair
##### For HKCC and SPEED students

## User Manual
### 1. Installation
1. Download from the apk installation file (~470 KB).
https://rawgit.com/beenotung/powerful-stair/master/download.html
2. Click "Next" and "Confirm" to start installation.
3. If above step fails, clean out some device space for at least 2 MB and try again.

### 2. First Time Use
1. Fill in your body status,
   1. Nickname
   2. Age
   3. Height (in m or cm) [Must Fill]
   4. Weight (in kg or lbs) [Must Fill]
2. Your BMI will be shown.
3. You can go to "My Status" / "我的狀態" to change the status anytime

##### Your personal information will not be send to any one. The data is used for conversation and stair related calculation only.

### 3. Stair recording
1. Click the "SCANNER" / "掃描器" up the top-right of the app
2. Scan the QR label near the stair, you will receive feedback message.
   1. "OK! Move On @v@"
   2. "OK! 繼續前行 @v@"
    - Keep on moving up/down the stair
   3. "Emm... Try again ^^;"
   4. "Emm... 再試一次 ^^;"
    - Scan the QR label again in different distance.
3. Climb up / walk down the stair
4. Scan the QR label near the stair
   1. "OK! Recorded ;->"
   2. "OK！已記錄;- >"
    - Your stair climbing is recorded.
   3. "Emm... Try again ^^;"
   4. "Emm... 再試一次 ^^;"
    - Scan the QR label again in different distance.

##### Keep your weight updated to increase the accuracy of stair climbing energy consumption.

### 4. Personal stair walking track
1. Open the navigation drawer (導航欄)
   1. Click the app icon on the top-left corner
   2. Swipe from left corner to right
2. Click "My Record" / "我的記錄" in the drawer
3. Enter your weekly target (in unit of cal)
4. The running icon indicate your weekly progress
5. Press and Hold the week row to change the weekly goal

### 5. Healthy tips
1. ExerciseRx website 運動處方
2. Exercise and Nutrition 運動與營養

   ##### These websites are provided by the government.

#### You can watch this page (user manuel) any time from the app under "About"/"關於".

## Updated list
1. fixed runner progress bar background issue
2. added Chinese support in app
3. updated website reference

# ________________
##### For developer
This is my first android project, sorry for the poor style. -by Beeno
## Todo list (developer)
1. improve week record layout
   1. move week tag into header line
   2. show week target
   3. add absolute progress (e.g. 4.5 kcal)
   4. show alternative bg color by month
   (e.g. June white, July light-yellow, Augest white)
   5. implement extensive linear layout
   (e.g show previous month preview. After click, show each week)
2. add Chinese support in user manual
   (by line or two separated page)
3. rewrite page content (fragment) approach
   1. use "include" in main activity xml
   2. build abstract comm fragment
      1. extract from ResLinker
      2. abstract onShow() similar to MyWebFragment

## Contributor
 - Supervisor
    - Karly Chan
 - Programming
    - Beeno Tung
 - Art work
    - Percy Ho
    - 荃荃(to confirm name)
