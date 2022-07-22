# What is NPM?
NPM stands for Node Package Manager
It's a repository where we can publish, download, and share third party code/packages
Comes preinstalled with Node

# NPM commands

# npm init
# npm init -y
This creates a project in the specified folder. Creates a package.json

# npm install <package-name> (put react in it)
# npm i <package-name>
Installs the specified package to our project and add it to our package.json as a dependency

# npm i
Install all dependencies into node_modules if not present

# npm uninstall <package-name>
Uninstall the specified package

# -D
Flags the install as a "devDepedency". Doesn't get shipped to the production build
# --production
Indicates that the project is running in "production". All devDependencies are excluded.

## package.json
This is the project descriptor

## package-lock.json
The lock file serves as the single source of truth and "locks" the version of each dependency in stone
Not only for the ones we directly install, but also for the dependency's dependencies

# node_modules
is a folder containing all the library source code
