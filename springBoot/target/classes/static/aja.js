const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
app.use(bodyParser.json());
app.use(cors());

let accounts = {}; // In-memory storage (Replace with a database in production)

// Create Account
app.post('/api/bank/create', (req, res) => {
    const { accountId, accountHolderName, initialBalance } = req.body;
    if (!accountId || !accountHolderName || initialBalance === undefined) {
        return res.status(400).json({ error: 'Missing required fields' });
    }
    if (accounts[accountId]) {
        return res.status(400).json({ error: 'Account already exists' });
    }
    accounts[accountId] = { accountHolderName, balance: parseFloat(initialBalance) };
    res.json({ message: 'Account created successfully!' });
});

// Get Account Info
app.get('/api/bank/account/:accountId', (req, res) => {
    const account = accounts[req.params.accountId];
    if (!account) {
        return res.status(404).json({ error: 'Account not found' });
    }
    res.json(account);
});

// Deposit Money
app.post('/api/bank/deposit', (req, res) => {
    const { accountId, amount } = req.body;
    if (!accountId || amount <= 0) {
        return res.status(400).json({ error: 'Invalid input' });
    }
    const account = accounts[accountId];
    if (!account) {
        return res.status(404).json({ error: 'Account not found' });
    }
    account.balance += parseFloat(amount);
    res.json({ message: `Deposited $${amount} successfully! New balance: $${account.balance}` });
});

// Withdraw Money
app.post('/api/bank/withdraw', (req, res) => {
    const { accountId, amount } = req.body;
    if (!accountId || amount <= 0) {
        return res.status(400).json({ error: 'Invalid input' });
    }
    const account = accounts[accountId];
    if (!account) {
        return res.status(404).json({ error: 'Account not found' });
    }
    if (account.balance < amount) {
        return res.status(400).json({ error: 'Insufficient balance' });
    }
    account.balance -= parseFloat(amount);
    res.json({ message: `Withdrew $${amount} successfully! New balance: $${account.balance}` });
});

const PORT = 3000;
app.listen(PORT, () => console.log(`Banking API running on port ${PORT}`));
