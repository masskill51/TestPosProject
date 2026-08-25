# Test POS Backend

Spring Boot API for the Android POS apps. It reads the **same Aiven MySQL database** as the desktop Madam POS (`products`, `sales`, `sale_items`, `users`).

## Endpoints

- `GET /api/health`
- `GET /api/inventory` — TestPos dashboard format
- `GET /api/products` — MYPOS product format
- `GET /api/sales/report` — today's totals
- `GET /api/sales/summary`
- `GET /api/sales/reports/cashier`
- `GET /api/users`

## Database

Set Railway (or local) environment variables to the Madam POS Aiven database:

- `DATABASE_URL=jdbc:mysql://posdatabase-marc93722-5909.d.aivencloud.com:11854/defaultdb?sslMode=REQUIRED`
- `DATABASE_USER=avnadmin`
- `DATABASE_PASSWORD=` (Aiven password)
- `POS_API_KEY=` (a long random value also configured in the Android app)
- `POS_TIME_ZONE=Asia/Manila`

These secrets are required; there are no credentials in `application.properties`.

After changing the database, redeploy this backend so the phone app and desktop POS stay in sync.

All data endpoints require `X-API-Key`. `GET /api/health` remains public for
hosting health checks.
