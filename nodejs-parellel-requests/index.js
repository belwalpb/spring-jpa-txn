const axios = require('axios');

let requestCount = 20;
let httpUrl = 'http://localhost:8080/transfer-amount?sourceAccount=1&destAccount=2&amount=1';

async function sendParallelRequests(url, n) {
  const requests = [];

  try {
    for (let i = 0; i < n; i++) {
      const startTime = new Date(); // Record the start time for each request
      const requestPromise = axios.get(url);
      requests.push(requestPromise.then(response => {
        const endTime = new Date(); // Record the end time for each request
        const timeTaken = endTime - startTime; // Calculate the time taken
        console.log(`Request ${i + 1} - Time Taken: ${timeTaken}ms`);
        console.log(response.data); // Do something with the response data
      }));
    }

    // Wait for all requests to complete
    await Promise.all(requests);
  } catch (error) {
    console.error('Error:', error.message);
  }
}

sendParallelRequests(httpUrl, requestCount);