# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.5

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build

# Include any dependencies generated for this target.
include glfw-3.2.1/tests/CMakeFiles/title.dir/depend.make

# Include the progress variables for this target.
include glfw-3.2.1/tests/CMakeFiles/title.dir/progress.make

# Include the compile flags for this target's objects.
include glfw-3.2.1/tests/CMakeFiles/title.dir/flags.make

glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o: glfw-3.2.1/tests/CMakeFiles/title.dir/flags.make
glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o: ../glfw-3.2.1/tests/title.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && /usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/title.dir/title.c.o   -c /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/tests/title.c

glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/title.dir/title.c.i"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && /usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/tests/title.c > CMakeFiles/title.dir/title.c.i

glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/title.dir/title.c.s"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && /usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/tests/title.c -o CMakeFiles/title.dir/title.c.s

glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.requires:

.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.requires

glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.provides: glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.requires
	$(MAKE) -f glfw-3.2.1/tests/CMakeFiles/title.dir/build.make glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.provides.build
.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.provides

glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.provides.build: glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o


glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o: glfw-3.2.1/tests/CMakeFiles/title.dir/flags.make
glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o: ../glfw-3.2.1/deps/glad.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && /usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/title.dir/__/deps/glad.c.o   -c /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/deps/glad.c

glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/title.dir/__/deps/glad.c.i"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && /usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/deps/glad.c > CMakeFiles/title.dir/__/deps/glad.c.i

glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/title.dir/__/deps/glad.c.s"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && /usr/bin/cc  $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/deps/glad.c -o CMakeFiles/title.dir/__/deps/glad.c.s

glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.requires:

.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.requires

glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.provides: glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.requires
	$(MAKE) -f glfw-3.2.1/tests/CMakeFiles/title.dir/build.make glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.provides.build
.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.provides

glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.provides.build: glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o


# Object files for target title
title_OBJECTS = \
"CMakeFiles/title.dir/title.c.o" \
"CMakeFiles/title.dir/__/deps/glad.c.o"

# External object files for target title
title_EXTERNAL_OBJECTS =

glfw-3.2.1/tests/title: glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o
glfw-3.2.1/tests/title: glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o
glfw-3.2.1/tests/title: glfw-3.2.1/tests/CMakeFiles/title.dir/build.make
glfw-3.2.1/tests/title: glfw-3.2.1/src/libglfw3.a
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/librt.so
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/libm.so
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/libX11.so
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/libXrandr.so
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/libXinerama.so
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/libXxf86vm.so
glfw-3.2.1/tests/title: /usr/lib/x86_64-linux-gnu/libXcursor.so
glfw-3.2.1/tests/title: glfw-3.2.1/tests/CMakeFiles/title.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable title"
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/title.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
glfw-3.2.1/tests/CMakeFiles/title.dir/build: glfw-3.2.1/tests/title

.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/build

glfw-3.2.1/tests/CMakeFiles/title.dir/requires: glfw-3.2.1/tests/CMakeFiles/title.dir/title.c.o.requires
glfw-3.2.1/tests/CMakeFiles/title.dir/requires: glfw-3.2.1/tests/CMakeFiles/title.dir/__/deps/glad.c.o.requires

.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/requires

glfw-3.2.1/tests/CMakeFiles/title.dir/clean:
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests && $(CMAKE_COMMAND) -P CMakeFiles/title.dir/cmake_clean.cmake
.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/clean

glfw-3.2.1/tests/CMakeFiles/title.dir/depend:
	cd /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01 /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/glfw-3.2.1/tests /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests /media/sohilbammi/Storage/School/CS184/public_html/assign/as1/example_01/build/glfw-3.2.1/tests/CMakeFiles/title.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : glfw-3.2.1/tests/CMakeFiles/title.dir/depend

