# Use an official Node.js runtime as a parent image
FROM node:14 as build

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the entire project to the working directory
COPY . .

# Build the React app
RUN npm run build

# Create a new image using a lightweight Node.js runtime
FROM node:14-slim

# Set the working directory
WORKDIR /app

# Copy the build files from the 'build' directory of the previous stage
COPY --from=build /app/build ./build

# Install a simple HTTP server to serve the React app
RUN npm install -g serve

# Expose the port your app will run on
EXPOSE 3000

# Define the command to run your React app
CMD ["serve", "-s", "build", "-l", "3000"]
