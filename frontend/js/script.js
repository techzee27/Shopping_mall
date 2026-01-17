// Configuration for API URL
// Un-comment the line below for local development
const API_BASE_URL = 'http://localhost:8080';
// Un-comment the line below for production (Render) - REPLACE WITH YOUR RENDER URL
// const API_BASE_URL = 'https://shopping-mall-backend.onrender.com';

const entities = {
    malls: {
        title: 'Malls',
        endpoint: `${API_BASE_URL}/mall`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'mallName', label: 'Mall Name', type: 'text' },
            { key: 'location', label: 'Location', type: 'text' },
            { key: 'categories', label: 'Categories', type: 'text' }
        ]
    },
    shops: {
        title: 'Shops',
        endpoint: `${API_BASE_URL}/shop`,
        idField: 'shopId',
        fields: [
            { key: 'shopId', label: 'Shop ID', type: 'number', readonly: true },
            { key: 'shopName', label: 'Shop Name', type: 'text' },
            { key: 'shopCategory', label: 'Category', type: 'text' },
            { key: 'shopStatus', label: 'Status', type: 'text' },
            { key: 'leaseStatus', label: 'Lease Status', type: 'text' },
            { key: 'mall', label: 'Mall ID', type: 'number', isObject: true, objectKey: 'id', displayKey: 'mallName' }
        ]
    },
    items: {
        title: 'Items',
        endpoint: `${API_BASE_URL}/item`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'name', label: 'Item Name', type: 'text' },
            { key: 'price', label: 'Price', type: 'number' },
            { key: 'manufacturing', label: 'Mfg Date', type: 'date' },
            { key: 'expiry', label: 'Expiry Date', type: 'date' },
            { key: 'category', label: 'Category', type: 'text' },
            { key: 'shop', label: 'Shop ID', type: 'number', isObject: true, objectKey: 'shopId', displayKey: 'shopName' }
        ]
    },
    employees: {
        title: 'Employees',
        endpoint: `${API_BASE_URL}/employee`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'name', label: 'Name', type: 'text' },
            { key: 'designation', label: 'Designation', type: 'text' },
            { key: 'salary', label: 'Salary', type: 'number' },
            { key: 'address', label: 'Address', type: 'text' },
            { key: 'dob', label: 'Date of Birth', type: 'date' },
            { key: 'shop', label: 'Shop ID', type: 'number', isObject: true, objectKey: 'shopId', displayKey: 'shopName' }
        ]
    },
    customers: {
        title: 'Customers',
        endpoint: `${API_BASE_URL}/customer`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'name', label: 'Name', type: 'text' },
            { key: 'phone', label: 'Phone', type: 'text' },
            { key: 'email', label: 'Email', type: 'email' },
            { key: 'item', label: 'Item ID', type: 'number', isObject: true, objectKey: 'id', displayKey: 'name' }
        ]
    },
    orders: {
        title: 'Order Details',
        endpoint: `${API_BASE_URL}/order`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'total', label: 'Total Amount', type: 'number' },
            { key: 'paymentMode', label: 'Payment Mode', type: 'text' },
            { key: 'dateOfPurchase', label: 'Date', type: 'datetime-local' },
            { key: 'customer', label: 'Customer ID', type: 'number', isObject: true, objectKey: 'id', displayKey: 'name' },
            { key: 'shop', label: 'Shop ID', type: 'number', isObject: true, objectKey: 'shopId', displayKey: 'shopName' }
        ]
    },
    admins: {
        title: 'Mall Admins',
        endpoint: `${API_BASE_URL}/mallAdmin`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'name', label: 'Name', type: 'text' },
            { key: 'phone', label: 'Phone', type: 'text' },
            { key: 'password', label: 'Password', type: 'password' },
            { key: 'mall', label: 'Mall ID', type: 'number', isObject: true, objectKey: 'id', displayKey: 'mallName' }
        ]
    },
    owners: {
        title: 'Shop Owners',
        endpoint: `${API_BASE_URL}/shopOwner`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'name', label: 'Name', type: 'text' },
            { key: 'address', label: 'Address', type: 'text' },
            { key: 'dob', label: 'Date of Birth', type: 'date' },
            { key: 'shop', label: 'Shop ID', type: 'number', isObject: true, objectKey: 'shopId', displayKey: 'shopName' }
        ]
    },
    users: {
        title: 'Users',
        endpoint: `${API_BASE_URL}/user`,
        idField: 'id',
        fields: [
            { key: 'id', label: 'ID', type: 'number', readonly: true },
            { key: 'name', label: 'Username', type: 'text' },
            { key: 'type', label: 'Type', type: 'text' },
            { key: 'password', label: 'Password', type: 'password' },
            { key: 'customer', label: 'Customer ID', type: 'number', isObject: true, objectKey: 'id', displayKey: 'name' }
        ]
    }
};

let currentEntity = null;
let currentData = [];

// DOM Elements
const navItems = document.querySelectorAll('#nav-list li');
const contentArea = document.getElementById('content-area');
const pageTitle = document.getElementById('page-title');
const modal = document.getElementById('modal');
const modalTitle = document.getElementById('modal-title');
const dataForm = document.getElementById('data-form');
const formFields = document.getElementById('form-fields');
const toast = document.getElementById('toast');

// Event Listeners
navItems.forEach(item => {
    item.addEventListener('click', () => {
        const target = item.getAttribute('data-target');
        if (target === 'dashboard') {
            loadDashboard();
        } else {
            loadEntity(target);
        }

        // Update active class
        navItems.forEach(n => n.classList.remove('active'));
        item.classList.add('active');
    });
});

document.querySelector('.close-btn').addEventListener('click', () => {
    modal.classList.add('hidden');
});

async function loadDashboard() {
    pageTitle.textContent = 'Dashboard';
    contentArea.innerHTML = `
        <div class="dashboard-grid" id="stats-grid">
            <p>Loading stats...</p>
        </div>
        <div class="charts-section">
            <div class="chart-card">
                <h3>System Overview</h3>
                <canvas id="overviewChart"></canvas>
            </div>
            <div class="chart-card">
                <h3>Shop Status Distribution</h3>
                <canvas id="statusChart"></canvas>
            </div>
            <div class="chart-card" style="grid-column: 1 / -1;">
                <h3>Top Performing Shops (Revenue)</h3>
                <canvas id="topShopsChart" style="max-height: 300px;"></canvas>
            </div>
        </div>

        <h3 class="dashboard-section-title">Recent Orders</h3>
        <div class="data-table-container">
            <table class="recent-orders-table" style="width: 100%;">
                <thead>
                    <tr>
                        <th style="text-align: left;">Order ID</th>
                        <th style="text-align: left;">Customer</th>
                        <th style="text-align: left;">Shop</th>
                        <th style="text-align: left;">Amount</th>
                        <th style="text-align: left;">Date</th>
                        <th style="text-align: left;">Status</th>
                    </tr>
                </thead>
                <tbody id="recent-orders-body">
                    <tr><td colspan="6">Loading recent orders...</td></tr>
                </tbody>
            </table>
        </div>
    `;
    currentEntity = null;

    try {
        const [malls, shops, items, employees, customers, orders] = await Promise.all([
            fetch(`${API_BASE_URL}/mall`).then(res => res.json()),
            fetch(`${API_BASE_URL}/shop`).then(res => res.json()),
            fetch(`${API_BASE_URL}/item`).then(res => res.json()),
            fetch(`${API_BASE_URL}/employee`).then(res => res.json()),
            fetch(`${API_BASE_URL}/customer`).then(res => res.json()),
            fetch(`${API_BASE_URL}/order`).then(res => res.json())
        ]);

        const totalRevenue = orders.reduce((sum, order) => sum + (order.total || 0), 0);

        const stats = [
            { label: 'Total Revenue', value: '$' + totalRevenue.toLocaleString(), icon: '💰', color: '#10b981' },
            { label: 'Total Malls', value: malls.length || 0, icon: '🏢', color: '#2563eb' },
            { label: 'Active Shops', value: shops.length || 0, icon: '🏪', color: '#10b981' },
            { label: 'Items Inventory', value: items.length || 0, icon: '📦', color: '#f59e0b' },
            { label: 'Employees', value: employees.length || 0, icon: '👥', color: '#8b5cf6' },
            { label: 'Total Customers', value: customers.length || 0, icon: '👤', color: '#ec4899' },
            { label: 'Total Orders', value: orders.length || 0, icon: '🛒', color: '#6366f1' }
        ];

        // Render Stats Cards
        document.getElementById('stats-grid').innerHTML = stats.map(stat => `
            <div class="stat-card" style="border-top: 4px solid ${stat.color}">
                <div class="stat-icon">${stat.icon}</div>
                <div class="stat-value">${stat.value}</div>
                <div class="stat-title">${stat.label}</div>
            </div>
        `).join('');

        // Render Overview Chart (Bar)
        new Chart(document.getElementById('overviewChart'), {
            type: 'bar',
            data: {
                labels: ['Malls', 'Shops', 'Items', 'Employees', 'Customers', 'Orders'],
                datasets: [{
                    label: 'Count',
                    data: [malls.length, shops.length, items.length, employees.length, customers.length, orders.length],
                    backgroundColor: ['#2563eb80', '#10b98180', '#f59e0b80', '#8b5cf680', '#ec489980', '#6366f180'],
                    borderColor: ['#2563eb', '#10b981', '#f59e0b', '#8b5cf6', '#ec4899', '#6366f1'],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                scales: { y: { beginAtZero: true } }
            }
        });

        // Calculate Shop Status for Pie Chart
        const statusCounts = {};
        shops.forEach(shop => {
            const status = shop.shopStatus || 'Unknown';
            statusCounts[status] = (statusCounts[status] || 0) + 1;
        });

        // Render Status Chart (Pie)
        new Chart(document.getElementById('statusChart'), {
            type: 'doughnut',
            data: {
                labels: Object.keys(statusCounts),
                datasets: [{
                    data: Object.values(statusCounts),
                    backgroundColor: [
                        '#10b981', '#ef4444', '#f59e0b', '#3b82f6', '#8b5cf6'
                    ]
                }]
            },
            options: { responsive: true }
        });

        // Calculate Top Shops by Revenue
        const shopRevenue = {};
        orders.forEach(order => {
            const shopName = order.shop ? order.shop.shopName : 'Unknown Shop';
            shopRevenue[shopName] = (shopRevenue[shopName] || 0) + (order.total || 0);
        });

        const sortedShops = Object.entries(shopRevenue)
            .sort((a, b) => b[1] - a[1])
            .slice(0, 5);

        new Chart(document.getElementById('topShopsChart'), {
            type: 'bar',
            data: {
                labels: sortedShops.map(s => s[0]),
                datasets: [{
                    label: 'Revenue ($)',
                    data: sortedShops.map(s => s[1]),
                    backgroundColor: '#8b5cf680',
                    borderColor: '#8b5cf6',
                    borderWidth: 1
                }]
            },
            options: {
                indexAxis: 'y',
                responsive: true
            }
        });

        // Render Recent Orders
        const recentOrders = [...orders]
            .sort((a, b) => new Date(b.dateOfPurchase) - new Date(a.dateOfPurchase))
            .slice(0, 5);

        document.getElementById('recent-orders-body').innerHTML = recentOrders.map(order => `
            <tr>
                <td>${order.id}</td>
                <td>${order.customer ? order.customer.name : 'Guest'}</td>
                <td>${order.shop ? order.shop.shopName : '-'}</td>
                <td>$${order.total}</td>
                <td>${new Date(order.dateOfPurchase).toLocaleDateString()}</td>
                <td><span style="padding: 4px 8px; background: #d1fae5; color: #065f46; border-radius: 4px; font-size: 0.8em;">Completed</span></td>
            </tr>
        `).join('');

    } catch (error) {
        console.error('Error loading dashboard stats:', error);
        document.getElementById('stats-grid').innerHTML = '<p style="color:red">Failed to load statistics.</p>';
    }
}

// Load dashboard initially
document.addEventListener('DOMContentLoaded', () => {
    loadDashboard();
});

function loadEntity(entityKey) {
    const config = entities[entityKey];
    if (!config) return;

    currentEntity = config;
    pageTitle.textContent = config.title;

    // Initial Render with Loading
    contentArea.innerHTML = '<p>Loading...</p>';

    fetch(config.endpoint)
        .then(response => response.json())
        .then(data => {
            currentData = data;
            renderTable(data, config);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            contentArea.innerHTML = '<p style="color: red">Error loading data. Check backend connection.</p>';
        });
}

function renderTable(data, config) {
    const tableHTML = `
        <div class="action-bar">
            <button class="btn primary" onclick="openAddModal()">+ Add New ${config.title.slice(0, -1)}</button>
        </div>
        <div class="data-table-container">
            <table>
                <thead>
                    <tr>
                        ${config.fields.map(f => `<th>${f.label}</th>`).join('')}
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    ${data.map(item => `
                        <tr>
                            ${config.fields.map(f => `<td>${renderCell(item, f)}</td>`).join('')}
                            <td>
                                <button class="btn secondary btn-sm" onclick="openEditModal(${item[config.idField]})">Edit</button>
                                <button class="btn danger btn-sm" onclick="deleteItem(${item[config.idField]})">Delete</button>
                            </td>
                        </tr>
                    `).join('')}
                </tbody>
            </table>
        </div>
    `;
    contentArea.innerHTML = tableHTML;
}

function renderCell(item, field) {
    if (field.isObject) {
        // Handle nested object display
        const obj = item[field.key];
        if (!obj) return '-';

        if (field.displayKey && obj[field.displayKey]) {
            return obj[field.displayKey];
        }

        return obj[field.objectKey] || 'Linked';
    }
    return item[field.key] || '-';
}

// Modal & Form Handling
window.openAddModal = function () {
    modalTitle.textContent = `Add ${currentEntity.title.slice(0, -1)}`;
    renderForm();
    dataForm.onsubmit = (e) => handleFormSubmit(e, 'POST');
    modal.classList.remove('hidden');
};

window.openEditModal = function (id) {
    const item = currentData.find(d => d[currentEntity.idField] === id);
    if (!item) return;

    modalTitle.textContent = `Edit ${currentEntity.title.slice(0, -1)}`;
    renderForm(item);
    dataForm.onsubmit = (e) => handleFormSubmit(e, 'PUT', id);
    modal.classList.remove('hidden');
};

function renderForm(data = {}) {
    formFields.innerHTML = currentEntity.fields.map(field => {
        // Getting initial value
        let value = data[field.key] || '';
        if (field.isObject && data[field.key]) {
            value = data[field.key][field.objectKey];
        }

        if (field.readonly && !value) return ''; // Don't show ID field on Add

        return `
            <div class="form-group">
                <label>${field.label}</label>
                <input 
                    type="${field.type}" 
                    name="${field.key}" 
                    value="${value}"
                    placeholder="Enter ${field.label}"
                    ${field.readonly ? 'readonly' : ''}
                    ${field.type === 'number' ? 'step="any"' : ''}
                    required
                >
            </div>
        `;
    }).join('');
}

function handleFormSubmit(e, method, id = null) {
    e.preventDefault();
    const formData = new FormData(dataForm);
    const payload = {};

    currentEntity.fields.forEach(field => {
        if (field.readonly && method === 'POST') return; // Skip ID for new items

        let value = formData.get(field.key);

        // Convert types
        if (field.type === 'number') value = Number(value);

        if (field.isObject) {
            // Construct nested object with ID only
            if (value) {
                payload[field.key] = { [field.objectKey]: value };
            } else {
                payload[field.key] = null;
            }
        } else {
            payload[field.key] = value;
        }
    });

    // For PUT, ensure ID is present in body typically
    if (method === 'PUT' && id) {
        payload[currentEntity.idField] = id;
    }

    fetch(currentEntity.endpoint, {
        method: method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
    })
        .then(response => {
            if (response.ok) {
                showToast('Saved Successfully');
                modal.classList.add('hidden');
                loadEntity(Object.keys(entities).find(key => entities[key] === currentEntity)); // Reload
            } else {
                showToast('Error saving data');
            }
        })
        .catch(err => console.error(err));
}

window.deleteItem = function (id) {
    if (!confirm('Are you sure you want to delete this item?')) return;

    fetch(`${currentEntity.endpoint}/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                showToast('Deleted Successfully');
                loadEntity(Object.keys(entities).find(key => entities[key] === currentEntity)); // Reload
            } else {
                showToast('Error deleting item');
            }
        });
};

function showToast(message) {
    toast.textContent = message;
    toast.classList.remove('hidden');
    setTimeout(() => {
        toast.classList.add('hidden');
    }, 3000);
}
