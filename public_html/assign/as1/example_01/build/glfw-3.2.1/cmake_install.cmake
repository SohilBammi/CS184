# Install script for directory: /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1

# Set the install prefix
if(NOT DEFINED CMAKE_INSTALL_PREFIX)
  set(CMAKE_INSTALL_PREFIX "/usr/local")
endif()
string(REGEX REPLACE "/$" "" CMAKE_INSTALL_PREFIX "${CMAKE_INSTALL_PREFIX}")

# Set the install configuration name.
if(NOT DEFINED CMAKE_INSTALL_CONFIG_NAME)
  if(BUILD_TYPE)
    string(REGEX REPLACE "^[^A-Za-z0-9_]+" ""
           CMAKE_INSTALL_CONFIG_NAME "${BUILD_TYPE}")
  else()
    set(CMAKE_INSTALL_CONFIG_NAME "")
  endif()
  message(STATUS "Install configuration: \"${CMAKE_INSTALL_CONFIG_NAME}\"")
endif()

# Set the component getting installed.
if(NOT CMAKE_INSTALL_COMPONENT)
  if(COMPONENT)
    message(STATUS "Install component: \"${COMPONENT}\"")
    set(CMAKE_INSTALL_COMPONENT "${COMPONENT}")
  else()
    set(CMAKE_INSTALL_COMPONENT)
  endif()
endif()

# Install shared libraries without execute permission?
if(NOT DEFINED CMAKE_INSTALL_SO_NO_EXE)
  set(CMAKE_INSTALL_SO_NO_EXE "1")
endif()

if(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/include" TYPE DIRECTORY FILES "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/include/GLFW" FILES_MATCHING REGEX "/glfw3\\.h$" REGEX "/glfw3native\\.h$")
endif()

if(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3" TYPE FILE FILES
    "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/src/glfw3Config.cmake"
    "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/src/glfw3ConfigVersion.cmake"
    )
endif()

if(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")
  if(EXISTS "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3/glfw3Targets.cmake")
    file(DIFFERENT EXPORT_FILE_CHANGED FILES
         "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3/glfw3Targets.cmake"
         "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/CMakeFiles/Export/lib/cmake/glfw3/glfw3Targets.cmake")
    if(EXPORT_FILE_CHANGED)
      file(GLOB OLD_CONFIG_FILES "$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3/glfw3Targets-*.cmake")
      if(OLD_CONFIG_FILES)
        message(STATUS "Old export file \"$ENV{DESTDIR}${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3/glfw3Targets.cmake\" will be replaced.  Removing files [${OLD_CONFIG_FILES}].")
        file(REMOVE ${OLD_CONFIG_FILES})
      endif()
    endif()
  endif()
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3" TYPE FILE FILES "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/CMakeFiles/Export/lib/cmake/glfw3/glfw3Targets.cmake")
  if("${CMAKE_INSTALL_CONFIG_NAME}" MATCHES "^()$")
    file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib/cmake/glfw3" TYPE FILE FILES "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/CMakeFiles/Export/lib/cmake/glfw3/glfw3Targets-noconfig.cmake")
  endif()
endif()

if(NOT CMAKE_INSTALL_COMPONENT OR "${CMAKE_INSTALL_COMPONENT}" STREQUAL "Unspecified")
  file(INSTALL DESTINATION "${CMAKE_INSTALL_PREFIX}/lib/pkgconfig" TYPE FILE FILES "/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/src/glfw3.pc")
endif()

if(NOT CMAKE_INSTALL_LOCAL_ONLY)
  # Include the install script for each subdirectory.
  include("/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/src/cmake_install.cmake")
  include("/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/examples/cmake_install.cmake")
  include("/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests/cmake_install.cmake")

endif()

