#!/bin/bash
      # Helper script for Gradle to call npm on macOS in case it is not found
      export PATH=$PATH:/usr/local/lib/node_modules/npm/node_modules/npm-lifecycle/node-gyp-bin:/Users/lifamily/Documents/GT/HackGT7/NurseApp/Scrubs/NursingClient/node_modules/nodejs-mobile-react-native/node_modules/.bin:/Users/lifamily/Documents/GT/HackGT7/NurseApp/Scrubs/NursingClient/node_modules/.bin:/Users/lifamily/opt/anaconda3/bin:/Users/lifamily/opt/anaconda3/condabin:/Library/Frameworks/Python.framework/Versions/3.8/bin:/Users/lifamily/.sdkman/candidates/springboot/current/bin:/Users/lifamily/.sdkman/candidates/maven/current/bin:/Users/lifamily/.sdkman/candidates/groovy/current/bin:/Users/lifamily/.sdkman/candidates/gradle/current/bin:/Users/lifamily/mongodb/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin:/Users/lifamily/Downloads/flutter/bin
      npm $@
    