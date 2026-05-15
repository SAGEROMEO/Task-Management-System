[Task_Management_System_Documentation.pdf](https://github.com/user-attachments/files/27794639/Task_Management_System_Documentation.pdf)

from weasyprint import HTML

# Updated HTML content with the new file information and logic
updated_html_content = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <style>
        @page {
            size: A4;
            margin: 15mm 12mm;
            background-color: #f8f9fa;
        }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            line-height: 1.6;
            color: #2c3e50;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #1a252f;
            color: #ffffff;
            padding: 40px 20px;
            margin: -15mm -12mm 30px -12mm;
            text-align: center;
            border-bottom: 5px solid #3498db;
        }
        h1 { margin: 0; font-size: 26pt; text-transform: uppercase; letter-spacing: 2px; }
        h2 { color: #2980b9; border-left: 5px solid #2980b9; padding-left: 10px; margin-top: 30px; font-size: 18pt; }
        h3 { color: #34495e; font-size: 14pt; margin-top: 20px; }
        .section { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); margin-bottom: 20px; }
        code { background-color: #f0f3f5; padding: 2px 6px; border-radius: 4px; font-family: 'Consolas', monospace; color: #e74c3c; }
        pre { background-color: #2c3e50; color: #ecf0f1; padding: 15px; border-radius: 6px; font-family: 'Consolas', monospace; font-size: 10pt; line-height: 1.4; }
        ul { padding-left: 20px; }
        li { margin-bottom: 10px; }
        .file-list { display: table; width: 100%; border-collapse: collapse; margin-top: 10px; }
        .file-item { display: table-row; border-bottom: 1px solid #eee; }
        .file-name { display: table-cell; padding: 8px; font-weight: bold; color: #2980b9; }
        .file-desc { display: table-cell; padding: 8px; font-style: italic; }
    </style>
</head>
<body>
    <div class="header">
        <h1>Task Management System</h1>
        <p>Advanced Java Implementation & Architecture Documentation</p>
    </div>

    <div class="section">
        <h2>🚀 Project Overview</h2>
        <p>This project is a sophisticated Task Management System built using <strong>Java 17+</strong>. It showcases modern enterprise patterns, including a robust task hierarchy, custom sorting engines, and functional data processing. The system handles multiple task types (Simple and Scheduled) and manages user data through immutable structures.</p>
    </div>

    <div class="section">
        <h2>📂 Core Project Structure</h2>
        <div class="file-list">
            <div class="file-item">
                <div class="file-name">Task.java</div>
                <div class="file-desc">The root abstract class defining universal task properties (ID, description, priority).</div>
            </div>
            <div class="file-item">
                <div class="file-name">SimpleTask.java</div>
                <div class="file-desc">A concrete implementation for basic, non-dated tasks.</div>
            </div>
            <div class="file-item">
                <div class="file-name">ScheduledTask.java</div>
                <div class="file-desc">A <code>sealed</code> class for tasks with due dates, permitting <code>TaskManager</code>.</div>
            </div>
            <div class="file-item">
                <div class="file-name">TaskComparator.java</div>
                <div class="file-desc">Custom sorting logic for ranking tasks based on priority levels.</div>
            </div>
            <div class="file-item">
                <div class="file-name">UserRecord.java</div>
                <div class="file-desc">A modern <code>record</code> for immutable, boilerplate-free user data.</div>
            </div>
            <div class="file-item">
                <div class="file-name">TaskManager.java</div>
                <div class="file-desc">The <code>non-sealed</code> central engine for filtering, assigning, and sorting tasks.</div>
            </div>
        </div>
    </div>

    <div class="section">
        <h2>🛠️ Technical Implementation</h2>
        
        <h3>1. Modern Java Features</h3>
        <ul>
            <li><strong>Sealed Hierarchies:</strong> Restricted inheritance using <code>sealed</code>, <code>non-sealed</code>, and <code>permits</code> for better domain modeling.</li>
            <li><strong>Java Records:</strong> Leveraging <code>UserRecord</code> for concise, immutable data carriers.</li>
            <li><strong>Pattern Matching:</strong> Utilizing enhanced <code>instanceof</code> for safer and cleaner type casting.</li>
        </ul>

        <h3>2. Data Management</h3>
        <ul>
            <li><strong>Bounded Generics:</strong> <code>TaskManager&lt;T extends Task&gt;</code> ensures only valid task types are processed.</li>
            <li><strong>Collections Framework:</strong> Uses <code>HashMap</code> for fast lookup and <code>HashSet</code> for ensuring unique users.</li>
            <li><strong>Functional Streams:</strong> Extensive use of <code>Collectors.groupingBy</code>, <code>filter</code>, and <code>Optional</code>.</li>
        </ul>
    </div>

    <div class="section">
        <h2>🔧 Setup & Usage</h2>
        <p>Ensure you have <strong>JDK 17 or higher</strong> installed to support sealed classes and records.</p>
        <pre>
# Compile the project
javac *.java

# Run the simulation
java Main
        </pre>
    </div>

    <div class="section">
        <h2>📊 System Capabilities</h2>
        <ul>
            <li><strong>Dynamic Sorting:</strong> Automated task ranking via the <code>TaskComparator</code>.</li>
            <li><strong>Assignment Logic:</strong> Stream-based lookup to link <code>UserRecords</code> to specific <code>Tasks</code>.</li>
            <li><strong>Priority Filtering:</strong> Threshold-based task isolation using functional <code>Predicates</code>.</li>
        </ul>
    </div>
</body>
</html>
"""

# Write HTML
with open("Task_System_Documentation_V2.html", "w") as f:
    f.write(updated_html_content)

# Convert to PDF
HTML(filename="Task_System_Documentation_V2.html").write_pdf("Task_Management_System_Documentation.pdf")
