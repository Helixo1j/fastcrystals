# Fast Crystals (Fabric 1.21.11)

Removes the 4-tick right-click delay while holding an end crystal.

## Build
1. Install JDK 21.
2. In this folder run: gradle wrapper --gradle-version 9.2.1
   (needs any installed Gradle; or copy a gradle wrapper from another Fabric project)
3. Run: ./gradlew build        (Windows: gradlew.bat build)
4. Jar is at build/libs/fastcrystals-1.0.0.jar
5. Put it in .minecraft/mods with Fabric Loader 0.18.1+ and Fabric API for 1.21.11.

## Notes
- Client-side only. Server still allows ~1 placement per tick (~20/sec max).
- Public servers with anti-cheat will likely flag this. Use in singleplayer,
  on your own server, or where it's explicitly allowed.
- If Gradle says a version doesn't exist, grab the newest from
  https://fabricmc.net/develop and edit gradle.properties.

## Build without installing anything (GitHub)
1. Create a free GitHub account and a new repository.
2. Upload everything in this folder (including the hidden .github folder).
3. Open the repo's Actions tab, wait for the "build" run to finish (green check).
4. Open the run, download the "fastcrystals-jar" artifact, unzip it for the .jar.
